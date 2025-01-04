package Composite;

import java.util.ArrayList;
import java.util.List;

public class MenuSection implements MenuComponent {
    private String sectionName;
    private List<MenuComponent> menuComponents;

    public MenuSection(String sectionName) {
        this.sectionName = sectionName;
        this.menuComponents = new ArrayList<>();
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void print() {
        System.out.println("Section: " + sectionName);
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}