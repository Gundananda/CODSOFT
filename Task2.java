import java.util.Scanner;
//Grade calculation  .

public class Task2{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("enter no of subjects:");
        int n = sc.nextInt();

        System.out.println("enter marks out of 100 in each subject:");
        int sum =0;
        for(int i=1; i<=n; i++){
            System.out.println("subject"+i+": ");
            int mark = sc.nextInt();
            sum+=mark;
        }
        int avg =sum/n;
        char Grade;
        if(avg>90 && avg<=100){
            Grade = 'A';
        }else if(avg>80 && avg<=90){
            Grade = 'B';
        }else if(avg>70 && avg<=80){
            Grade = 'C';
        }else if(avg>60 && avg<=70){
            Grade = 'D';
        }else{
            Grade = 'F';
        }

        System.out.println("total marks: "+sum);
        System.out.println("average marks: "+avg);
        System.out.println("grade obtained: "+Grade);
    }
}