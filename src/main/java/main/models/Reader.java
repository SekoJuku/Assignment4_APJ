package main.models;

public class Reader {
    public int reader_id;
    public String reader_name;
    public String reader_address;
    public String reader_phone;

    public Reader(int reader_id, String reader_name, String reader_address, String reader_phone) {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_address = reader_address;
        this.reader_phone = reader_phone;
    }

    public String getPhone() {
        return reader_phone;
    }

    public int getId() {
        return reader_id;
    }

    public String getName() {
        return reader_name;
    }

    public String getAddress() {
        return reader_address;
    }
}
