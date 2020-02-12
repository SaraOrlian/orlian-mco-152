package orlian.projectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectileMath {

    public static final int NUM_PROJECTILES = 5;

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList <Projectile> ProjectileList = new ArrayList<Projectile>();

        for (int j = 0; j < NUM_PROJECTILES; j++) {
            ProjectileList.add(new Projectile(rand.nextDouble() * 181, rand.nextDouble() * 100));
        }

        for(Projectile projectile : ProjectileList){
            for (int i = 0; i < ProjectileList.size(); i++) {
                int num1 = 1;
                ProjectileList.get(i).increaseTime(num1);
                System.out.println(ProjectileList.get(i).toString());
            }
        }
    }
}
s