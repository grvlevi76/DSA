#include<stdio.h>
#include<string.h>

//converting infix expression without bracket into postfix without stack

int solve(int postfix[],int n);

void main() {
    /*char exp[] = "2*3/3-5*2+1-1+3*5";
    char priority[] ="/*";
    int used[10];
    int exist,e=0,p=0,repl,n,found;
    char temp;
    printf("infix expression : %s\n",exp);
    while(p!=strlen(priority)+1) {
        e=0;
        n=0;
        while(e!=strlen(exp)) {
            found=0;
            for(int i=0;i<n;i++) {
                if(e==used[i]) {
                    found=1;
                    break;
                }
            }
            if(found==1) {
                e++;
                continue;
            }

            //check for priority operator(*or/) then + and - (according to encounter from left to right)
            if((p==strlen(priority) && (exp[e]=='+'||exp[e]=='-'))||priority[p]==exp[e]) {  
                exist =e;

                repl=exist+2;
                while(repl<strlen(exp) && exp[repl] !='+' && exp[repl] !='-') {
                    repl++;
                }
                repl--;
                //shifting
                temp = exp[exist];
                while(exist!=repl) {
                    exp[exist]=exp[exist+1];
                    exist++;
                }
                exp[repl] =temp;
                //used index save
                used[n] =repl;
                n++;
            }
            e++;
        }
        p++;
    }
    printf("expression after postfix : %s\n",exp);*/
    int postf[] ={5,3,2,'*','+',19,'-'};
    int n = sizeof(postf)/sizeof(int);
    printf("solution = %d\n",solve(postf,n));


}

int solve(int postfix[],int n) {
    int stack[10];
    int x=0,e=0,found;
    while(e!=n) {
        if(postfix[e]=='/'||postfix[e]=='*'||postfix[e]=='+'||postfix[e]=='-') {
            x=x-2;
            switch(postfix[e]) {
                case '+':
                    stack[x]=stack[x]+stack[x+1];
                    break;
                case '-':
                    stack[x]=stack[x]-stack[x+1];
                    break;

                case '*':
                    stack[x]=stack[x]*stack[x+1];
                    break;

                case '/':
                    stack[x]=stack[x]/stack[x+1];
                    break;

                default :
                    printf("invalid operator\n");
                    
            }
        }else {
            stack[x]=postfix[e];
        }
        x++;
        e++;
    }
    return stack[0];
}



//this solution only works in case of single digit value and without breacket ,solve it for multiple digit expression
//use stack method for postfix
//if u r using int array to store postfix expression then comparing the number which is gonna be equal to the ascii of operator gonna create problem
//so make new structure 'isoperator' and value then 'isoperator' =1 if operator is stored in int array