use std::env;
use std::fs;

fn main() {
    let mut file = File::open("test.txt")?;
    let mut contents = String::new();
    file.read_to_string(&mut contents)?;
    println!(contents);
}