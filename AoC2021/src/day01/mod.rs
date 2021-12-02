use core::num;
use std::vec;

pub fn solve_part_1() -> String {
    let input = include_str!("input.txt");
    let mut previous = 0;
    let mut total = 0;
    for line in input.lines() {
        let number = line.parse::<i32>().unwrap();
        if previous == 0 {
            previous = number;
        } else {
            if previous < number {
                total += 1;
                //println!("{} (increased)", number);
                previous = number;
            } else if previous > number {
                //println!("{} (decreased)", number);
                previous = number;
            }
        }
    }

    total.to_string()
}

pub fn solve_part_2() -> String {
    let input = include_str!("input.txt");
    let mut total = 0;
    let mut list: Vec<u32> = Vec::new();
    for line in input.lines() {
        let mut current_set = 0;
        let mut previous_set = 0;
        let number = line.parse::<u32>().unwrap();
        if list.len() < 3 {
            list.push(number);
            println!("{}", number)
        } else if list.len() == 3 {
            previous_set += list[0];
            previous_set += list[1];
            previous_set += list[2];
            list.remove(0);
            list.push(number);
            current_set += list[0];
            current_set += list[1];
            current_set += list[2];
        }
        if previous_set < current_set {
            total += 1;
        }
    }
    total.to_string()
}
