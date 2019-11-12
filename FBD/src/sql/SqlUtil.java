package sql;

public class SqlUtil {


	public final static String URL = "jdbc:mysql://127.0.0.1:3306?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=true&"
			+ "&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false";
    public static String USUARIO = "root";
    public static String SENHA = "adson";

    public static class Validar{
    	public static String GET_RG = "select distinct f.identidade,m.rg  from rotasviagens.funcionario f join rotasviagens.motorista m where identidade = ? or rg = ?;";

    	public static String VALIDAR_LOGIN = "SELECT email,senha FROM rotasviagens.funcionario where email = ? and senha = ?;";

    }

    public static class Funcioario {


        public static String INSERT_ALL = "INSERT INTO rotasviagens.funcionario (nome,cpf,identidade,email,senha,endereco_id)"
                + "VALUES (?,?,?,?,?,?) ";

        public static String GETALL = "SELECT id,nome,cpf,endereco_id,identidade,email FROM rotasviagens.funcionario;";

        public static String DELETE = "DELETE FROM rotasviagens.funcionario WHERE id = ?";

        public static String GET = "SELECT * FROM rotasviagens.funcionario where id = ?;";

        public static String UPDATE = "update rotasviagens.funcionario set nome = ?, cpf = ?, identidade = ?, email = ?"
        								+ "where id = ?;";


//        public static String GET_CPF = "select distinct f.cpf,m.cpf  from rotasviagens.funcionario f join rotasviagens.motorista m where cpf = ? or cpf = ?;";

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

    public static class Motorista{
        public static String INSERT_ALL = "INSERT INTO rotasviagens.motorista (nome,telefone,cnh,categoria_cnh,cpf,rg,endereco_id)"
                + "VALUES (?,?,?,?,?,?,?) ";

        public static String GETALL = "SELECT * FROM rotasviagens.motorista;";

        public static String DELETE = "DELETE FROM rotasviagens.motorista WHERE id_motorista = ?";

        public static String GET = "SELECT * FROM rotasviagens.motorista where id_motorista = ?;";

        public static String GET_RG = "SELECT * FROM rotasviagens.motorista where rg = ?;";

        public static String UPDATE = "update rotasviagens.motorista set nome = ?, telefone = ? ,cnh = ?, categoria_cnh = ?, "
        								+ "cpf = ?, rg = ? where id_motorista = ?;";

    }

    public static class Veiculo{

        public static String INSERT_ALL = "INSERT INTO rotasviagens.veiculo "
                + "(placa,uf,tipo_carroceria,tipo_veiculo,modelo,ano,cor,cod_renavam,kms,capacidade)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?) ";

        public static String GETALL = "SELECT * FROM rotasviagens.veiculo;";

        public static String DELETE = "DELETE FROM rotasviagens.veiculo WHERE id_veiculo = ?";

        public static String GET = "SELECT * FROM rotasviagens.veiculo where id_veiculo = ?;";

        public static String UPDATE = "update rotasviagens.veiculo set placa = ?, uf = ? ,tipo_carroceria = ?, tipo_veiculo = ?, "
				+ "modelo = ?, ano = ?, cor = ?, cod_renavam = ?, kms = ?, capacidade = ? where id_veiculo = ?;";


        public static String GET_PLACA = "SELECT * FROM rotasviagens.veiculo where placa = ?";



    }

    public static class Rota {

        public static String INSERT_ALL = "INSERT INTO rotasviagens.rota "
                + "(origem,destino,kms,combustivel,tempo_previsto,descricao) VALUES (?,?,?,?,?,?) ";

        public static String GETALL = "SELECT * FROM rotasviagens.rota;";

        public static String DELETE = "DELETE FROM rotasviagens.rota WHERE id_rota = ?";

        public static String GET = "SELECT * FROM rotasviagens.rota where id_rota = ?;";

        public static String UPDATE = "update rotasviagens.rota set origem = ?, destino = ?, kms = ?, combustivel = ?, tempo_previsto = ?, descricao = ? where id_rota = ?;";


    }

    public static class Carga{

        public static String INSERT_ALL = "INSERT INTO rotasviagens.carga "
                + "(tipo,quantidade_uni,peso_total,valor_total,fabricacao,validade,descricao) VALUES (?,?,?,?,?,?,?) ";

        public static String GETALL = "SELECT * FROM rotasviagens.carga;";

        public static String DELETE = "DELETE FROM rotasviagens.carga WHERE id_carga = ?";

        public static String GET = "SELECT * FROM rotasviagens.carga where id_carga = ?;";

        public static String UPDATE = "update rotasviagens.carga set tipo = ?, quantidade_uni = ?, peso_total = ?, valor_total = ?, fabricacao = ?, validade = ?, descricao = ? where id_carga = ?;";
    }

    public static class Viagem {

        public static String INSERT_ALL = "insert into rotasviagens.viagem (data_saida,data_chegada,status,descricao," +
        "motorista_id_motorista,veiculo_id_veiculo, rota_id_rota,carga_id_carga) values (?,?,?,?,?,?,?,?)";

        public static String GETALL = "SELECT * FROM rotasviagens.viagem;";

        public static String DELETE = "DELETE FROM rotasviagens.viagem WHERE id_viagem = ?";

        public static String GET = "SELECT * FROM rotasviagens.viagem where id_viagem = ?;";

        public static String UPDATE = "update rotasviagens.viagem set data_saida = ?, data_chegada = ?, status = ?, descricao = ?," +
        "motorista_id_motorista = ?, veiculo_id_veiculo = ?, rota_id_rota = ?, carga_id_carga = ? where id_viagem = ?;";


    }

    public static class Caixa{

        public static String GETALL = "select distinct  c.descricao,c.valor_total,v.data_saida,v.data_chegada"+
        		" from rotasviagens.carga c join rotasviagens.viagem v on c.id_carga = v.carga_id_carga;";

    }


}
