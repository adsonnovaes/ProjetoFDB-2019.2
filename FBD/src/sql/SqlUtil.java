package sql;

public class SqlUtil {

    public static String URL = "jdbc:postgresql://localhost:5432/RotasViagens";
    public static String USUARIO = "postgres";
    public static String SENHA = "2301@adson";

    public static class Funcioario {

        public static String INSERT_ALL = "insert into funcionario (nome,cpf,identidade,email,senha,endereco_id) "
                + "values (?,?,?,?,?,?) ";

        public static String EDITAR_ALL = "update funcionario set nome =?, cpf=?, .... WHERE id = ?";

    }

    public static class Endereco {

        public static String INSERT_ALL = "insert into endereco (rua, numero,bairro,cidade,estado) "
                + "values (?,?,?,?,?) ";
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
