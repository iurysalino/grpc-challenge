package parquet;

import java.io.IOException;
import java.util.List;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;

/**
 * Difine a constructor to use for write parquet file.
 */
public class CustomParquetWriter extends ParquetWriter<List<String>> {

  public CustomParquetWriter(
      Path file,
      MessageType schema,
      boolean enableDictionary,
      CompressionCodecName codecName) throws IOException {
    super(file, new CustomWriteSupport(schema), codecName, DEFAULT_BLOCK_SIZE, DEFAULT_PAGE_SIZE,
        enableDictionary, false);
  }
}
