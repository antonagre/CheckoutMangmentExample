//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.02.10 alle 02:51:13 PM CET 
//


package orderspace;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the orderspace package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: orderspace
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddProductToOrderResponse }
     * 
     */
    public AddProductToOrderResponse createAddProductToOrderResponse() {
        return new AddProductToOrderResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link GetOrderTotalResponse }
     * 
     */
    public GetOrderTotalResponse createGetOrderTotalResponse() {
        return new GetOrderTotalResponse();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link CreateOrderRequest }
     * 
     */
    public CreateOrderRequest createCreateOrderRequest() {
        return new CreateOrderRequest();
    }

    /**
     * Create an instance of {@link AddProductToOrderRequest }
     * 
     */
    public AddProductToOrderRequest createAddProductToOrderRequest() {
        return new AddProductToOrderRequest();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
//    public Product createProduct() {
//        return new Product();
//    }

    /**
     * Create an instance of {@link GetOrderTotalRequest }
     * 
     */
    public GetOrderTotalRequest createGetOrderTotalRequest() {
        return new GetOrderTotalRequest();
    }

}
