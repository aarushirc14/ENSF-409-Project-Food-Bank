package edu.ucalgary.ensf409;

public class OrderCannotBeFilledException extends Exception{
    public OrderCannotBeFilledException() throws Exception{
        throw new Exception("The order cannot be fulfilled due to errors");
    }
}
