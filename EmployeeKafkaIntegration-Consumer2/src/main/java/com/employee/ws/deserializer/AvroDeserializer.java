package com.employee.ws.deserializer;


import com.employee.ws.core.EmployeeEvent;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class AvroDeserializer implements Deserializer<EmployeeEvent> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No config needed
    }

    @Override
    public EmployeeEvent deserialize(String topic, byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        try {
            DatumReader<EmployeeEvent> reader = new SpecificDatumReader<>(EmployeeEvent.class);
            Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
            return reader.read(null, decoder);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize Avro Employee", e);
        }
    }

    @Override
    public void close() {
        // No resources to close
    }
}
