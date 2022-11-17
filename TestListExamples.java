 
import static org.junit.Assert.*;
 
import java.beans.Transient;
 
import org.junit.*;
 
import java.util.List;
import java.util.LinkedList;
 
 
public class TestListExamples {
 // Write your grading tests here!
 
 @Test
 public void testfilter(){
   List<String> actual= new LinkedList<>();
   List<String> expected= new LinkedList<>();
   StringChecker sc = new StringCheck();
   actual.add("bacon");
   actual.add("baconbits");
   actual.add("letsgetbacon");
   expected.add("baconbits");
   expected.add("letsgetbacon");
   actual = ListExamples.filter(actual, sc);
   assertArrayEquals(expected.toArray(), actual.toArray());
 
 
 }
 
 @Test
 public void testmerge(){
   List<String> actual1= new LinkedList<>();
   List<String> actual2= new LinkedList<>();
   actual1.add("A");
   actual1.add("C");
   actual1.add("E");
   actual2.add("B");
   actual2.add("D");
   actual1 = ListExamples.merge(actual1,actual2);
   List<String> expected= new LinkedList<>();
   expected.add("A");
   expected.add("B");
   expected.add("C");
   expected.add("D");
   expected.add("E");
   assertArrayEquals(expected.toArray(), expected.toArray());
 }
}
 
class StringCheck implements StringChecker{
 public boolean checkString(String s){
 if(s.length() > 5){
   return true;
 }
 return false;
}
 
}
 

