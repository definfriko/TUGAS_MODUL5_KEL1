package tugas_modul5_kel1;

public class userService {
	private String[][] data = new String[2][3];
    private String[][] history = new String[2][4];
    private String email, password, roles = "";
    int book;
    
    public userService(String emails, String passwords)
    {
        email = emails;
        password = passwords;
        String[][] data = 
        { 
            {"definkelompok1@gmail.com", "12345", "superAdmin"},
            {"ghalykelompok1@gmail.com", "12345", "user"} 
        };
        String[][] history =
        {
            {"definkelompok1@gmail.com","Fisika Dasar","Dasar Komputer dan Pemrograman","19-04-2020"},
            {"ghalykelompok1@gmail.com","Dasar Komputer dan Pemrograman","Konsep Jaringan Komputer","19-04-2020"}
        };
        this.data = data;
        this.history = history;
    }
    
    private boolean checkCredential()
    {
        for(int i = 0; i < data.length; i++ )
        {
            if(data[i][0].equals(email))
            {
                if(data[i][1].equals(password))
                {
                    if (data[i][0] == history[i][0])
                        book = i;
                    roles = data[i][2];
                    return true;
                }
            }
        }
        return false;
    }
    
    public void login()
    {
        boolean status = checkCredential();
        if(status == true)
        {
            System.out.println("\nWelcome " + roles);
            System.out.println("Logged it as user email " + email);
            System.out.println(email + " meminjam buku : ");
            for (int i=1; i<3; i++){
                System.out.println(history[book][i]);
            }
            System.out.println("Tanggal Pinjaman : " + history[book][3]);
        }
        else
        {
            System.out.println("\nInvalid Login ");

        }
    }
}
