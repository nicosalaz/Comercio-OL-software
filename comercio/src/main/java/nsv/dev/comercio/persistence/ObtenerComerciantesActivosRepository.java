package nsv.dev.comercio.persistence;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class ObtenerComerciantesActivosRepository {

	private final JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	public ObtenerComerciantesActivosRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("obtener_comerciantes_activos")
				.declareParameters(new SqlOutParameter("return", OracleTypes.CURSOR));
	}

	public boolean exportarComerciantesCSV(String filePath) {
		try (PrintWriter writer = new PrintWriter(filePath)) {
			writer.println("NOMBRE|NOMBRE MUNICIPIO|TELEFONO|CORREO|FECHA REGISTRO|ESTADO|"
					+ "CANTIDAD ESTABLECIMIENTOS|TOTAL INGRESOS|CANTIDAD EMPLEADOS|");
			Map<String, Object> result = simpleJdbcCall.execute();
			List<Map<String, Object>> rs = (List<Map<String, Object>>) result.get("return");
			for (Map<String, Object> map : rs) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					String key = entry.getKey();
					Object val = entry.getValue();
					if (map.get(key).getClass().getSimpleName().equals(String.class.getSimpleName())) {
						writer.append((String) val + "|");
					} else if (map.get(key).getClass().getSimpleName().equals(Timestamp.class.getSimpleName())) {
						writer.append((Timestamp) val + "|");
					} else if (map.get(key).getClass().getSimpleName().equals(BigDecimal.class.getSimpleName())) {
						writer.append((BigDecimal) val + "|");
					}
				}
				writer.append("\n");
			}
			return true;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
