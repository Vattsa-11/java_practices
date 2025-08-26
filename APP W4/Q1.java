public class Q1 {
    static class Bank{
        private
        String accType = "String";
        double principle;
        float rate, time;

        public
        Bank(double p, float r, float t, String type){
            accType = type;
            principle = p;
            rate = r;
            time = t;
        }
    }
}