package material;

//import static org.junit.jupiter.api.Assertions.*;

//Tạo mới 5 đối tượng bột, 5 đối tượng thịt
//
//        Viết lớp quản lý Vật liệu cho phép thêm sửa xóa vật liệu.
//
//        Nếu thịt còn 5 ngày hết hạn thì giảm 30%, còn lại thì giảm 10%.
//        Nếu bột còn 2 tháng hết hạn thì giảm 40%, bột còn 4 tháng hết hạn thì giảm 20%, còn lại thì giảm 5%.

import java.time.LocalDate;

class MaterialTest {
    public static void main(String[] args) {
        Material flour1 = new CrispyFlour("01", "Bột đa dụng", LocalDate.of(2020, 5, 1), 23000, 0.7);
        Material flour2 = new CrispyFlour("02", "Bột nở", LocalDate.of(2021, 6, 20), 20000, 0.8);
        Material flour3 = new CrispyFlour("03", "Bột gạo", LocalDate.of(2019, 5, 13), 13000, 0.9);
        Material flour4 = new CrispyFlour("04", "Bột chiên xù", LocalDate.of(2020, 10, 22), 31000, 0.82);
        Material flour5 = new CrispyFlour("05", "Bột chiên giòn", LocalDate.of(2021, 12, 10), 40000, 0.78);

        Material meat1 = new Meat("06", "Thịt lợn", LocalDate.of(2022, 6, 28), 56000, 0.7);
        Material meat2 = new Meat("07", "Thịt gà", LocalDate.of(2022, 7, 13), 50000, 0.85);
        Material meat3 = new Meat("08", "Thịt vịt", LocalDate.of(2022, 7, 28), 62000, 0.85);
        Material meat4 = new Meat("09", "Thịt bò", LocalDate.of(2022, 8, 2), 95000, 0.9);
        Material meat5 = new Meat("10", "Thịt chó", LocalDate.of(2022, 6, 30), 40000, 0.75);

        Material listMaterial[] = {flour1, flour2, flour3, flour4, flour5, meat1, meat2, meat3, meat4, meat5};
        showList(listMaterial);

        Material flour6 = new CrispyFlour("04", "Bột chiên xù", LocalDate.of(2020, 10, 22), 31000, 0.82);
        showList(addList(listMaterial, 5, flour6));
        showList(removeList(listMaterial, 5));

    }

    private static Material[] removeList(Material[] arrayBefore, int index) {
        Material[] arrayAfter = new Material[arrayBefore.length - 1];
        for (int i = 0; i < arrayBefore.length-1; i++) {
            if (i < index) {
                arrayAfter[i] = arrayBefore[i];
            } else {
                arrayAfter[i] = arrayBefore[i+1];
            }
        }
        return arrayAfter;
    }

    private static void showList(Material[] listMaterial) {
        for (int i = 0; i < listMaterial.length; i++) {
            System.out.println(listMaterial[i]);
        }
    }

    public static Material[] addList(Material[] arrayBefore, int index, Material value) {
        Material[] arrayAfter = new Material[arrayBefore.length + 1];
        for (int i = 0; i <= arrayBefore.length; i++) {
            if (i < index) {
                arrayAfter[i] = arrayBefore[i];
            } else if (i == index) {
                arrayAfter[i] = value;
            } else {
                arrayAfter[i] = arrayBefore[i-1];
            }
        }
        return arrayAfter;
    }
}