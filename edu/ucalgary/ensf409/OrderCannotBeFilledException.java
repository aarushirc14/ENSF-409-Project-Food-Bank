/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.1
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

public class OrderCannotBeFilledException extends Exception {
    public OrderCannotBeFilledException() throws Exception {
        throw new Exception("The order cannot be fulfilled due to errors");
    }
}
