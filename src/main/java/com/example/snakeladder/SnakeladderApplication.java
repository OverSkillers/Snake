package com.example.snakeladder;

import com.example.snakeladder.model.SnakeTrap;
import com.example.snakeladder.model.Stairs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.snakeladder.model.User;
import com.example.snakeladder.repository.UserRepository;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Snake{


	private final com.example.snakeladder.repository.UserRepository UserRepository;
	public Snake(UserRepository userRepository) {
		this.UserRepository = userRepository;
	}

	ArrayList<SnakeTrap> traps = new ArrayList<>();
	ArrayList<Stairs> stairs = new ArrayList<>();

	public ArrayList<Integer> diceRoll(){
		int dice1,dice2;
		Random r = new Random();
		dice1 = r.nextInt(6) + 1;
		dice2 = r.nextInt(6) + 1;

		ArrayList<Integer> values = new ArrayList<>();
		values.add(dice1);
		values.add(dice2);

		return values;
	}

	public void checkSnake(ArrayList<Integer> players, int current){
		for (SnakeTrap s: traps
		) {
			if(players.get(current) == s.getBegin()) {
				players.set(current,s.getEnd());
				System.out.println("You hit a snake");
			}
		}
	}

	public int position(int player, int dice){
		player += dice;

		System.out.println(player);

		for (SnakeTrap s: traps
		) {
			if(player == s.getBegin()) {
				player = s.getEnd();
				System.out.println("You hit a snake");
			}
		}

		for (Stairs s: stairs){
			if (player == s.getBegin()){
				player = s.getEnd();
				System.out.println("You hit a stair");
			}
		}

		return player;
	}


	public void start(){


		ArrayList<Integer> players = new ArrayList<>();
		int p1 = 1, p2 = 1, p3 = 1, p4 = 1;
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		int current = 0;
		int diference = 0;
		ArrayList<Integer> dice = new ArrayList<>();
		int diceResult = 0;
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println(traps.toString());

		do{
			do {
				current += 1;
				if(current == 1){
					input = scanner.next();
					System.out.println("Player " + current + " turn");
					System.out.println("Press 1 to roll");
					input = scanner.next();
					dice = diceRoll();
					diceResult = dice.get(0) + dice.get(1);
					System.out.println("You got " + dice.get(0) + " and " + dice.get(1) + " and it makes " + diceResult + "\n");
					players.set(0,position(players.get(0), diceResult));
					if (players.get(0) > 100){
						diference = players.get(0) - 100;
						players.set(0,100 - diference);
						checkSnake(players,0);
					}
					System.out.println("Your current position is " + players.get(0));
					if(dice.get(0) == dice.get(1)) {
						current -= 1;
					}
					if(players.get(0) == 100){
						System.out.println("You Win");
						return;
					}
					this.UserRepository.deleteById(1L);
					this.UserRepository.save(new User(1L,"Player1", players.get(0),diceResult));
				}
				if(current == 2){
					System.out.println("Player " + current + " turn");
					System.out.println("Press 1 to roll");
					input = scanner.next();
					dice = diceRoll();
					diceResult = dice.get(0) + dice.get(1);
					System.out.println("You got " + dice.get(0) + " and " + dice.get(1) + " and it makes " + diceResult + "\n");
					players.set(1,position(players.get(1), diceResult));
					if (players.get(1) > 100){
						diference = players.get(1) - 100;
						players.set(1,100 - diference);
						checkSnake(players,1);
					}
					System.out.println("Your current position is " + players.get(1));
					if(dice.get(0) == dice.get(1)) {
						current -= 1;
					}
					if(players.get(1) == 100){
						System.out.println("You Win");
						return;
					}
					this.UserRepository.deleteById(2L);
					this.UserRepository.save(new User(2L,"Player2", players.get(1),diceResult));;
				}
				if(current == 3){
					System.out.println("Player " + current + " turn");
					System.out.println("Press 1 to roll");
					input = scanner.next();
					dice = diceRoll();
					diceResult = dice.get(0) + dice.get(1);
					System.out.println("You got " + dice.get(0) + " and " + dice.get(1) + " and it makes " + diceResult + "\n");
					players.set(2,position(players.get(2), diceResult));
					if (players.get(2) > 100){
						diference = players.get(2) - 100;
						players.set(2,100 - diference);
						checkSnake(players,2);
					}
					System.out.println("Your current position is " + players.get(2));
					if(dice.get(0) == dice.get(1)) {
						current -= 1;
					}
					if(players.get(2) == 100){
						System.out.println("You Win");
						return;
					}
					this.UserRepository.deleteById(3L);
					this.UserRepository.save(new User(3L,"Player3", players.get(2),diceResult));
				}
				if(current>3){
					System.out.println("Player " + current + " turn");
					System.out.println("Press 1 to roll");
					input = scanner.next();
					dice = diceRoll();
					diceResult = dice.get(0) + dice.get(1);
					System.out.println("You got " + dice.get(0) + " and " + dice.get(1) + " and it makes " + diceResult + "\n");
					players.set(3,position(players.get(3), diceResult));
					if (players.get(3) > 100){
						diference = players.get(3) - 100;
						players.set(3,100 - diference);
						checkSnake(players,3);
					}
					System.out.println("Your current position is " + players.get(3));
					if(players.get(3) == 100){
						return;
					}
					if(dice.get(0) == dice.get(1)) {
						System.out.println("You Win");
						current -= 1;
					}else{
						current = 0;
					}
					this.UserRepository.deleteById(4L);
					this.UserRepository.save(new User(4L,"Player4", players.get(3),diceResult));
				}
				System.out.println(players);
			}while(dice.get(0) != dice.get(1));
		}while(true);
	}
}

@SpringBootApplication
public class SnakeladderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SnakeladderApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception {
		this.userRepository.save(new User(1L,"Player1", 1,0));
		this.userRepository.save(new User(2L,"Player2", 1,0));
		this.userRepository.save(new User(3L,"Player3", 1,0));
		this.userRepository.save(new User(4L,"Player4", 1,0));

		Snake snake = new Snake(this.userRepository);
		snake.traps.add(new SnakeTrap(62,19));
		snake.traps.add(new SnakeTrap(99,80));
		snake.traps.add(new SnakeTrap(64,60));
		snake.traps.add(new SnakeTrap(95,75));
		snake.traps.add(new SnakeTrap(46,25));
		snake.traps.add(new SnakeTrap(16,6));
		snake.traps.add(new SnakeTrap(49,11));
		snake.traps.add(new SnakeTrap(74,53));
		snake.traps.add(new SnakeTrap(89,68));
		snake.traps.add(new SnakeTrap(92,88));

		snake.stairs.add(new Stairs(21,42));
		snake.stairs.add(new Stairs(2,38));
		snake.stairs.add(new Stairs(78,98));
		snake.stairs.add(new Stairs(28,84));
		snake.stairs.add(new Stairs(15,26));
		snake.stairs.add(new Stairs(7,14));
		snake.stairs.add(new Stairs(8,31));
		snake.stairs.add(new Stairs(51,67));
		snake.stairs.add(new Stairs(71,91));
		snake.stairs.add(new Stairs(87,94));

		snake.start();
	}
}
