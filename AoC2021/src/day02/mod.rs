//let input = include_str!("input.txt");
use core::num;
use std::vec;

pub fn solve_part_1() -> String {
    let input = include_str!("input.txt");
    let mut horizontal = 0;
    let mut depth = 0;
    for line in input.lines() {
        let mut split: Vec<&str> = line.split(' ').collect();
        let number: i32 = split[1].parse().unwrap();
        if split[0].eq("down") {
            depth += number;
        }
        if split[0] == ("up") {
            depth -= number;
        }
        if split[0] == ("forward") {
            horizontal += number;
        }
    }
    let result = depth * horizontal;
    result.to_string()
}

pub fn solve_part_2() -> String {
    let input = include_str!("input.txt");
    let mut horizontal = 0;
    let mut depth = 0;
    let mut aim = 0;
    for line in input.lines() {
        let mut split: Vec<&str> = line.split(' ').collect();
        let number: i32 = split[1].parse().unwrap();
        if split[0].eq("down") {
            //depth += number;
            aim += number;
        }
        if split[0] == ("up") {
            //depth -= number;
            aim -= number;
        }
        if split[0] == ("forward") {
            horizontal += number;
            depth += aim * number;
        }
    }
    let result = depth * horizontal;
    result.to_string()
}
