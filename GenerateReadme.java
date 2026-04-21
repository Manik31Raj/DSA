public static Meta analyze(String code) {

    try {
        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("❌ ERROR: API KEY MISSING");
            return new Meta("Unknown", "Unknown", "Unknown");
        }

        String prompt = """
Return ONLY JSON:

{"pattern":"...","difficulty":"...","tc":"..."}

Code:
""" + code;

        String body = "{\n" +
                "\"model\": \"gpt-5.3\",\n" +
                "\"input\": " + escape(prompt) + "\n" +
                "}";

        HttpURLConnection conn = (HttpURLConnection)
                new URL("https://api.openai.com/v1/responses").openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        conn.getOutputStream().write(body.getBytes());

        int status = conn.getResponseCode();
        System.out.println("🔎 STATUS CODE: " + status);

        BufferedReader br;

        if (status >= 200 && status < 300) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            System.out.println("❌ ERROR RESPONSE FROM API:");
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder res = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            res.append(line);
        }

        System.out.println("🔥 FULL RESPONSE:");
        System.out.println(res.toString());

        // If API failed, return early
        if (status < 200 || status >= 300) {
            return new Meta("Error", "Error", "Error");
        }

        String content = extractResponse(res.toString());

        System.out.println("✅ EXTRACTED CONTENT:");
        System.out.println(content);

        return new Meta(
                get(content, "pattern"),
                get(content, "difficulty"),
                get(content, "tc")
        );

    } catch (Exception e) {
        System.out.println("💥 EXCEPTION OCCURRED:");
        e.printStackTrace();
        return new Meta("Error", "Error", "Error");
    }
}
