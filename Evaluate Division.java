class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = creatMap(equations, values);
        double[] res = new double[queries.size()];

        for (int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            Deque<String> qa = new ArrayDeque<>();
            qa.add(query.get(0));
            String b = query.get(1);
            res[i] = dfs(qa, 1, b, 1, map);
        }

        return res;
    }

    private static double dfs(Deque<String> qa, double va, String b, double vb, Map<String, Map<String, Double>> map) {
        String a = qa.element();

        if (!map.containsKey(a) || !map.containsKey(b))
            return -1;
        if (a.equals(b))
            return va / vb;

        double res;

        for (Map.Entry<String, Double> entry : map.get(a).entrySet()) {
            if (qa.contains(entry.getKey()))
                continue;

            qa.push(entry.getKey());
            res = dfs(qa, va * entry.getValue(), b, vb, map);
            qa.pop();

            if (Double.compare(res, -1) != 0)
                return res;
        }

        return -1;
    }

    private static Map<String, Map<String, Double>> creatMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            if (!map.containsKey(a))
                map.put(a, new HashMap<>());
            if (!map.containsKey(b))
                map.put(b, new HashMap<>());

            map.get(a).put(b, val);
            map.get(b).put(a, 1 / val);
        }

        return map;
    }
}