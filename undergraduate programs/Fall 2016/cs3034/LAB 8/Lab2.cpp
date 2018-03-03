#include <iostream>
#include <cstdlib>
using namespace std;

int main(){
	unsigned int seed;
	
	cout<< "Enter a number "<< endl;
	cin >> seed;
	srand(seed);


	
	
	int Random1 = 2000 + (rand() % (4999 - 2000));
	
	
	for(int i = 1 ; i < Random1 ; i++){
		
		if((i % 7 == 0) && (i % 11 == 0) && (i % 13 == 0)){
			cout << "What a llama" <<endl;
		}
		
		else if( ((i % 7 != 0) && (i % 11 != 0) && (i % 13 != 0)) || ((i % 7 == 0) && (i % 13 == 0)) || ((i % 7 == 0) && (i % 11 == 0)) || ((i % 11 == 0) && (i % 13 == 0)) ){
			
		}
		
		else if(i % 7 == 0){
			cout << i  << " Lucky" <<endl;
		}
		
		else if(i % 11 == 0){
			cout << i  << " Lively" <<endl;
		}
		
		else if(i % 13 == 0){
			cout << i  << " Llama" <<endl;
		}
		
	};

	return 0;
}
