public class MyClass {
    
    // Given a n*n matrix, find shortest distance between each vertices in the directed graph. If there are no edges between vertices it is represented by -1.
    
    //n^3 tc
    private void inPLaceFloydWarshall(int[][] matrix) {
        
        for(int i=0 ; i < matrix.length ; i++) {
             for(int j=0 ; j < matrix.length ; j++) {
                if(matrix [i][j] == -1) {
                        matrix [i][j] = 1e9;
                }
         }
        }
        
        for ( int k = 0; k < matrix.length ; k++){
            for(int i=0 ; i < matrix.length ; i++) {
              for(int j=0 ; j < matrix.length ; j++) {
                        matrix [i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                
           }
          }
        }
        // detect cycle 
            for(int i=0 ; i < matrix.length ; i++) {
                if(matrix[i][i] < 0){
                    System.out.println("Cycle detected");
                }
                }
        
        // back to -1
          for(int i=0 ; i < matrix.length ; i++) {
             for(int j=0 ; j < matrix.length ; j++) {
                if(matrix [i][j] == 1e9) {
                        matrix [i][j] = -1;
                }
            }
         
        }
        
    }
}
