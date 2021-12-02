//let input = include_str!("input.txt");
use core::num;
use std::vec;

pub fn solve_part_1() -> String {
    let input = include_str!("input.txt");
    let mut horizontal = 0;
    let mut depth = 0;
    for line in input.lines() {
        let mut split: = line.split(' ').collect();
        let number = split.parse();
        println!("{:?}", number);
        if split.eq("down"){
            let number = ;

            horizontal += split.next();
        } else if (split.next().cmp("forward"){
        } else if (split.next().cmp("up"){
        }
    }
    "".to_string()
}

pub fn solve_part_2() -> String {
    "".to_string()
}
