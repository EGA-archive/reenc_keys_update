package eu.elixir.ega.ebi.reencryption.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import eu.elixir.ega.ebi.reencryption.beans.Processed_files;

public class ProcessedfilesRowMapper implements RowMapper<Processed_files> {

    @Override
    public Processed_files mapRow(ResultSet rs, int arg1) throws SQLException {
        Processed_files pf = new Processed_files();
        pf.setFile_id(rs.getString("file_id"));
        pf.setKey(rs.getString("key"));
        pf.setEnc_key(rs.getString("enc_key"));
        return pf;
    }

}
