# PlaceholderActionbar

[日本語の README はこちらから](https://github.com/book000/PlaceholderActionbar/blob/master/README-ja.md)

Displays the specified text in the action bar at regular intervals. It works depending on [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/).

## Feature

- It will be displayed in the action bar for every hour set in the configuration.
- Replaces the PlaceholderAPI placeholder.
- Display only one message, rather than switching between multiple messages.
- You can toggle the feature on and off depending on the player.

## Dependency

Please install the following plugin together. If it is not installed, it will not work.

- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

## Supported Version

- Spigot 1.12.2, 1.15.2
  - (May be available for other versions)
- PlaceholderAPI 2.10.5

## Install

1. Go to [Release](https://github.com/book000/PlaceholderActionbar/releases) page.
2. Download latest version
3. Put the downloaded jar file in the `plugins` directory of the Spigot server directory.
4. If the server has already started, restart it by executing `/reload` or `/stop`.

## Command

### /placeholderactionbar

**Permission Node**: `placeholderactionbar.placeholderactionbar`

Displays the current on/off setting.

### /placeholderactionbar on

**Permission Node**: `placeholderactionbar.on`

Turn on the feature. The settings are kept for each player.

### /placeholderactionbar off

**Permission Node**: `placeholderactionbar.off`

Turn off the feature. The settings are kept for each player.

### /placeholderactionbar reload

**Permission Node**: `placeholderactionbar.reload`

Reload the configuration.

## Settings

It is set in `plugins/PlaceholderActionbar/config.yml` file.

### ActionbarText

Specify the text to be displayed in the action bar. Required.  
If you use a color code, enclose it with `'`.

Default value: `You are in §b%worldguard_region_owner%§r's §d%worldguard_region_name_capitalized%§r`

### RefreshTick

Specify the interval at which the text is periodically displayed in the action bar. Required.  
The time must be specified in Tick. 1 second is 20 Ticks.

Default value: `20` (Every second)

## License

The license for this project is MIT License.  
[LICENSE](https://github.com/book000/PlaceholderActionbar/blob/master/LICENSE)
