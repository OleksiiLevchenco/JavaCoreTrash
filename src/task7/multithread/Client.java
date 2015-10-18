package task7.multithread;

import java.util.List;

/**
 * @author Alexey Levchhenko
 */
public class Client {

    private String name;
    private List<Food> foodList;

    public Client(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public void displayFoodList(){
        for(Food food: foodList){
            System.out.println(food);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
