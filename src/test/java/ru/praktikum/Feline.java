package ru.praktikum;

import java.util.List;



public class Feline implements Predator {

        public List<String> eatMeat() throws Exception {
            return getFood("Хищник");
        }

        public String getFamily() {
            return "Кошачьи";
        }

        public int getKittens() {
            return getKittens(1);
        }

        public int getKittens(int kittensCount) {
            return kittensCount;
        }

        public List<String> getFood(String animalType) throws Exception {
            if ("Хищник".equals(animalType)) {
                return List.of("Животные", "Птицы", "Рыба");
            } else if ("Травоядное".equals(animalType)) {
                return List.of("Трава", "Различные растения");
            }
            throw new Exception("Неизвестный вид животного");
        }
}