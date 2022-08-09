public class TimeComplexity {
    public static void main(String[] args) {
        SOE(100000);

    }

    public static void SOE(int n){
        boolean[] prime = new boolean[n+1];
        prime[0] = prime[1]=true;
        for(int i = 0 ; i*i <=n;i++){
            if(prime[i]){
                continue;
            }
            for(int j=2;j*i<=n;j++){
                prime[i*j]= true;
            }
        }
        for (int i = 0; i < n; i++) {
            if(!prime[i]){
                System.out.print(i +", ");
            }
        }

    }
}
