use serde::Deserialize;

#[derive(Deserialize)]
struct Config {
    cmd: Cmd,
    variable: Variable,
    rules: Rules,
}

#[derive(Deserialize)]
struct Cmd {
    mount: String,
    unmount: String,
    zip: String,
    make_text_file: String,
}

#[derive(Deserialize)]
struct Variable {
    drive: String,
    net_path: String,
}

#[derive(Deserialize)]
struct Rules {
    dest: String,
    dir_filter: String,
    sub_dir1: [String; 3],
    sub_dir2: String,
} 

fn read_config() -> Config 
{
    let _config: Config = {
        let contents = std::fs::read_to_string("config.toml").expect("error reading config.toml");
        toml::from_str(&contents).expect("error parsing config.toml")
    };
    _config 
}
