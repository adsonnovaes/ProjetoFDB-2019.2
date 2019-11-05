package sql;

public class SqlUtil {


	public final static String URL = "jdbc:mysql://127.0.0.1:3306?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=true&"
			+ "&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false";
    public static String USUARIO = "root";
    public static String SENHA = "adson";

    public static class Funcioario {

        public static String INSERT_ALL = "INSERT INTO rotasviagens.funcionario (nome,cpf,identidade,email,senha,endereco_id) "
                + "VALUES (?,?,?,?,?,?) ";

        public static String EDITAR_ALL = "update funcionario set nome =?, cpf=?, .... WHERE id = ?";

    }

    public static class Endereco {

        public static String INSERT_ALL = "INSERT INTO endereco (funcionario_id,rua,num_casa,bairro,cep,cidade,uf) "
                + "VALUES (?,?,?,?,?,?,?) ";
    }
    public static class Viagem {

        public static String INSERT_ALL = "insert into Viagem (id_motorista, id_rota,id_veiculo,id_carga) "
                + "values (?,?,?,?) ";
    }

    public static class Rota {

        public static final String INSERT_ALL = "insert into rota () "
                + "values (?,?,?) ";

        public static final String SELECT_ID = "select * from rota where id = ?";

    }

    private SqlUtil() {

    }

}
