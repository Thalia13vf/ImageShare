package br.com.files.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.files.model.Arquivo;

public class FileDao {
	private DataSource dataSource;

	public FileDao(DataSource dt) {
		this.dataSource = dt;
	}

	public Arquivo getImage(int id) {
		try {
			String sql = "select * from files where id=?";
			PreparedStatement stm = (PreparedStatement) dataSource.getConnection().prepareStatement(sql);
			stm.setInt(1, id);
			
			ResultSet resultSet = stm.executeQuery();
			
			Arquivo arq = new Arquivo();
			if(resultSet.next()) {
				arq.setNome(resultSet.getString("nome"));
				arq.setId(resultSet.getInt("id"));
			}
			stm.close();
			return arq;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				this.dataSource.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Arquivo> listar() {
		try {
			String sql = "select id, nome from files";
			PreparedStatement stm = (PreparedStatement) dataSource.getConnection().prepareStatement(sql);
			ResultSet resultSet = stm.executeQuery();
			
			List<Arquivo> arquivos = new ArrayList<>();
			
			while(resultSet.next()) {
				Arquivo arq = new Arquivo();
				arq.setNome(resultSet.getString("nome"));
				arq.setId(resultSet.getInt("id"));
				arquivos.add(arq);
			}
			stm.close();
			return arquivos;
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				this.dataSource.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public byte[] getImageById(int id) {
		try {
			String sql = "select arquivo from files where id=?";
			PreparedStatement stm = (PreparedStatement) dataSource.getConnection().prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet set = stm.executeQuery();

			if(set.next()) {
				byte[] b = set.getBytes("arquivo");
				return b;
			}
			stm.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				this.dataSource.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void inserir(InputStream fis, String nome, int tamanhoArq) {
		InputStream input = fis;
		try {
			String sql = "insert into files values(null, ?, ?)";
			PreparedStatement st = (PreparedStatement) dataSource.getConnection().prepareStatement(sql);

			st.setBinaryStream(1, input, tamanhoArq); 
			st.setString(2, nome);
			
			st.execute();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				this.dataSource.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
