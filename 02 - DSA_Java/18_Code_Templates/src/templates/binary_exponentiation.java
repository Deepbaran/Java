package templates;

public class binary_exponentiation {
	// Find a^b
	private static long binpow(long a, long b, long mod) {
		a %= mod;
		long res=1;
		while(b>0) {
			if(b%2!=0) {
				res=(res*a)%mod;
				b--;
			}
			a=(a*a)%mod;
			b/=2;
		}
		return res;
	}
}
