package miscellaneous_practice;
public class AllocateBooksToStudents {
    /**
     * Given that there are N books and M students. Also given are the number of pages in each book in ascending order. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum, with the condition that every student is assigned to read some consecutive books. Print that minimum number of pages from Max number of PAGES is allocated to student in each set.
     * @param pages
     * @param student
     * @return
     */
    
    public static int minOfMaxPagesAllocated(int[] pages,int students) {

        // will usebinary search on max number of pages a student can have. Each book must be allocated. So minimum pages needs to be max of the array of pages.
        // max pages => what if only one student needs to be allocated then the max value is sum(array elements);
            int sum=0, max=Integer.MIN_VALUE;
            for(int i=0;i<pages.length;i++){
                max=Math.max(max,pages[i]);
                sum=sum+pages[i];
            }
            int low=max, high=sum;


            while(low<=high){

                int mid=(low+high)/2;
                if(studentForMaxPage(pages,mid)<=students){
                        high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            return high;
    }

    private static int studentForMaxPage(int[] pages, int maxPages) {
        int student=0, pagesForStudent=0;
        for(int i=0;i<pages.length;i++){
           
            if(pagesForStudent+pages[i]<=maxPages){
                pagesForStudent+=pages[i];
            }
            else{
                student++;
                pagesForStudent=pages[i];
            }
        }
        return student;
    }
     public static void main(String[] args) {
        
        int[] array={ 12, 34, 67, 90 };
        System.out.println();
     }
}
