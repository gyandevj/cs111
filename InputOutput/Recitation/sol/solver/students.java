public class students {
    public static void main(String[] args) {
        int numStudents = StdIn.readInt();
        String [] students = new String[numStudents * 4];
        for(int i = 0; i < numStudents; i++){
            students[i*4] = StdIn.readString();//first
            students[i*4 + 1] = StdIn.readString();//last
            students[i*4 + 2] = StdIn.readString();//netID
            students[i*4 + 3] = StdIn.readString();//section
        }

        for(int i = 0; i < numStudents * 4; i += 4){
            if(students[i+3].equals("4") || 
                students[i+3].equals("5")
            ){
                StdOut.println(students[i+2]);
            }
        }
        for(int i = 0; i < numStudents; i++){
            StdOut.println(students[i*4 + 1] + ", " + students[i*4 +0]);
        }
    }
}


