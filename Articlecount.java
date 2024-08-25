/*
Article count
Article count
 
Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such a program is called a thread. The threads are light-weight processes within a process.
         
Let's have a quick look at the way threads work in Java. For multi-threading to work, the class that will be invoked as a thread should extend the Thread class. You may wonder, what is the use of multi-threading. Let's understand it by the following exercise. Given 'n' number of lines of text, you have to find the total number of articles present in the given lines. while obtaining inputs from the user, the Main method has the full control of the execution.

The time is wasted in input gathering, which can be invaluable for large computing applications, has to be utilized properly. Hence a thread is invoked when a line is obtained and the articles are counted while the input for the subsequent lines is obtained from the user. Thus threading can increase efficiency and time constraints.

Strictly adhere to the Object-Oriented specifications given in the problem statement. All class names, attribute names and method names should be the same as specified in the problem statement.
 
Create a class called Article which extends the Thread class with the following private attributes.

Attributes	Datatype
line	String
count	Integer
 
Include appropriate getters and setters.
Generate default and parameterized constructors. The format for the parameterized constructor is Article(String line)

The Article class includes the following methods

Method 	Description
void run()	This method counts the number of articles in a given line and stores the value in the count variable.

Create a driver class called Main. In the Main method, invoke 'n' threads for 'n' lines of input and compute the total count of the articles in the given lines.

Input and Output format:
Refer to sample Input and Output for formatting specifications.

[All text in bold corresponds to the input and rest corresponds to the output]
Sample Input and Output:

Enter the number of lines
3
Enter line 1
An article is a word used to modify a noun, which is a person, place, object, or idea.
Enter line 2
Technically, an article is an adjective, which is any word that modifies a noun.
Enter line 3
There are two different types of articles.
There are 7 articles in the given input
 
*/


 public class Article extends Thread {
	private String line;
    private Integer count;
    
    Article() {}
    Article(String line) {
        this.line = line;
    }
    
    public void setLine(String line) { this.line = line; }
    public void setCount(Integer count) { this.count = count; }
    public String getLine() { return this.line; }
    public Integer getCount() { return this.count; }

    @Override
    public void run() {
        int c = 0;
        String[] words = this.line.split("[\\s,]+");
        for(String word : words) {
            if( (word.equals("a")) || (word.equals("A")) || (word.equals("an")) || (word.equals("An")) || (word.equals("the")) || (word.equals("The")) )    c++;
        }
        this.count = c;
    }
}




import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int n = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();
        int c = 0;
        for(int i=1;i<=n;i++) {
            System.out.println("Enter line "+i);
            Article article = new Article(sc.nextLine());
            articles.add(article);
            article.start();
            article.join();
        }
        
        for(Article article : articles) c += article.getCount();
        
        System.out.println("There are "+c+" articles in the given input");
        sc.close();
	}
}
