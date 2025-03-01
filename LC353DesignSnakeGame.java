import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class SnakeGame {

    private int width, height, foodId, score;

    private int[][] food;

    private Deque<Integer> snack;

    private Set<Integer> seen;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodId = 0;
        this.score = 0;
        this.snack = new ArrayDeque<>();
        this.seen = new HashSet<>();
        seen.add(0);
        snack.addLast(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Integer head = snack.peekLast();
        int r = head / width;
        int c = head % width;
        if(direction.equals("U")){
            r--;
        } else if(direction.equals("L")){
            c--;
        } else if(direction.equals("R")){
            c++;
        } else {
            r++;
        }
        // 1.第一种情况，是否超出边界
        if(r < 0 || r >= height || c < 0 || c >= width){
            return -1;
        }
        
        // 2. 第二种情况，吃到食物加头
        if(foodId < food.length && r == food[foodId][0] && c == food[foodId][1]){
            seen.add(r * width + c);
            snack.addLast(r * width + c);
            foodId++;
            return ++score;
        }

        // 3. 去尾
        seen.remove(snack.pollFirst());

        // 4. 检查是否与自身相撞
        if(seen.contains(r * width + c)){
            return -1;
        } else {
            // 5. 加头
            seen.add(r * width + c);
            snack.addLast(r * width + c);
            return score;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

// 作者：fanhua
// 链接：https://leetcode.cn/problems/design-snake-game/solutions/92835/shuang-duan-dui-lie-ha-xi-java-by-henrylee4/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。