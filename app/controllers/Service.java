package controllers;

import models.Item;
import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

public class Service extends Controller {

    public static Result priceList() {

        ArrayList<Item> priceList = new ArrayList<Item>();

        for (int i=0; i<10; i++) {
            Item item = new Item();
            item.setName("Item" + (i+1));
            item.setPrice((float) ((i+1) * Math.PI));
            priceList.add(item);
        }

        return ok(toJson(priceList));
    }
}
