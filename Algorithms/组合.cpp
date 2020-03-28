class Solution {
public:
	int judge(vector<int> p,int n,int k){
		if(p[0]!=n-k+1) return 1;
		else return 0;
	}
	vector<int> next(vector<int>& p,int n,int k){
		int i=0,temp=n;
		int *map;
		map=(int*)malloc(sizeof(int)*(n+2));
		for(i=0;i<n;i++)
			map[i+1]=0;
		for(i=k-1;i>=0;i--){
			map[p[i]]=1;
			if(p[i]+1<=n&&!map[p[i]+1]){
				p[i]=p[i]+1;
				break;
			}
		}
		for(i=i+1;i<k;i++){
			p[i]=p[i-1]+1;
		}
		return p;
	}
    vector<vector<int>> combine(int n, int k) {
		int i=0,sum=0,j;
		vector<vector<int>> r;
		vector<int> l;
		for(i=0;i<k;i++)
			l.push_back(i+1);
		r.push_back(l);
		while(judge(l,n,k)){
			l=next(l,n,k);
			r.push_back(l);
		}
		return r;
        
    }
};