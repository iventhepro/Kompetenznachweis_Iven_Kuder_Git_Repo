package ch.ilv.crm.web;

import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

import ch.ilv.crm.web.controller.CustomerController;
import ch.ilv.crm.web.controller.ProductController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class CrmApp {
		
    public static void main(String[] args) {

		Javalin app = Javalin.create();

		app._conf.addStaticFiles("C:\\Users\\PC109\\Documents\\GitHub\\Kompetenznachweis_Iven_Kuder_Github\\workspace_M154_knw\\maven\\m154-crm-web-maven\\resources\\public", Location.EXTERNAL);

        app.routes(() -> {
        	get(ch.ilv.crm.web.Path.Web.CUSTOMERS, CustomerController.showIndex);
        	post(Path.Web.CUSTOMER, CustomerController.selectCustomer);
        	post(Path.Web.CREATE_CUSTOMER, CustomerController.createCustomer);
        	
        	get(Path.Web.PRODUCTS, ProductController.showIndex);
        	post(Path.Web.PRODUCT, ProductController.selectProduct);
        	post(Path.Web.CREATE_PRODUCT, ProductController.createProduct);
        });
        
		app.error(404, ViewUtil.notFound);

		app.start(7070);
    }
}
