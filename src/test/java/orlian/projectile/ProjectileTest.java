package orlian.projectile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectileTest {

    @Test
    public void getX(){
        // given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        // when
        double x = projectile.getX();

        // then
        assertEquals(245.2557, x, 0.0001);
    }

    @Test
    public void getY(){
        // given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        // when
        double y = projectile.getY();

        // then
        assertEquals(83.5568, y, 0.0001);
    }

    @Test
    public void increaseTime(){
        // given
        Projectile projectile = new Projectile(53.26 ,82);

        // when time is not changed
        double time = projectile.getTime();

        // then
        assertEquals(0, time, 0.0001);

        // given
        Projectile projectile1 = new Projectile(53.26 ,82);

        // when add 5 to time
        projectile1.increaseTime(5);
        double time1 = projectile1.getTime();

        // then
        assertEquals(5, time1, 0.0001);
    }
}