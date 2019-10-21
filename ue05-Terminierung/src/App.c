#include <stdio.h>
#include <stdlib.h>

int f(int a, int b) {
	return a==b ? 1 : f(a, a) + f(a+1, b);
}

int main(int argc, char* argv[]) {
	if (argc==3)
		printf("%d\n", f(atoi(argv[1]),atoi(argv[2])));
	else
		printf("Please provide a and b!\n");
}
