package sql;

public class SqlUtil {


	public final static String URL = "jdbc:mysql://127.0.0.1:3306?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=true&"
			+ "&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false";
    public static String USUARIO = "root";
    public static String SENHA = "adson";

    public static class Funcioario {


        public static String INSERT_ALL = "INSERT INTO rotasviagens.funcionario (nome,cpf,identidade,email,senha,endereco_id)"
                + "VALUES (?,?,?,?,?,?) ";

        public static String GETALL = "SELECT id,nome,cpf,endereco_id,identidade,email FROM rotasviagens.funcionario;";

        public static String DELETE = "DELETE FROM rotasviagens.funcionario WHERE id = ?";

        public static String GET = "SELECT * FROM rotasviagens.funcionario where id = ?;";

        public static String UPDATE = "update rotasviagens.funcionario set nome = ?, cpf = ?, identidade = ?, email = ?"
        								+ "where id = ?;";

    }

    public static class Endereco {

        public static String INSERT_ALL = "INSERT INTO rotasviagens.endereco (rua,num_casa,bairro,cidade,uf) "
                + "VALUES (?,?,?,?,?) ";

        public static String GETALL = "SELECT id_endereco,rua,num_casa,bairro,cidade,uf FROM rotasviagens.endereco;";

        public static String GET = "SELECT * FROM rotasviagens.endereco where id_endereco = ?;";

        public static String DELETE = "DELETE FROM rotasviagens.endereco WHERE id_endereco = ?";

        public static String UPDATE = "update rotasviagens.endereco set rua = ?, num_casa = ?, bairro = ?, cidade = ?"
				+ ", uf = ? where id_endereco = ?;";

    }
    public static class Viagem {

        public static String INSERT_ALL = "insert into Viagem (id_motorista, id_rota,id_veiculo,id_carga) "
                + "values (?,?,?,?) ";
    }
    
    public static class Motorista{
    	
    	
    }

    public static class Rota {

        public static final String INSERT_ALL = "insert into rota () "
                + "values (?,?,?) ";

        public static final String SELECT_ID = "select * from rota where id = ?";

    }

    public static class Caixa{

    	public static final String BUSCA = "select ";
    }


}
