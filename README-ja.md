# PlaceholderActionbar

[Click here for English README](https://github.com/book000/PlaceholderActionbar/blob/master/README.md)

定期的に指定したテキストをアクションバーに表示します。[PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) に依存し動作します。

## 特徴

- コンフィグで設定した時間毎にアクションバーに表示します。
- PlaceholderAPI のプレースホルダーを置き換えます。
- 複数のメッセージを切り替えるのではなく、ひとつのメッセージのみを表示します。
- プレイヤーに応じて機能のオン・オフを切り替えることができます。

## 依存関係

次のプラグインを一緒に導入してください。導入されていない場合動作しません。

- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

## サポートバージョン

- Spigot 1.12.2, 1.15.2
  - (それ以外のバージョンでも多分利用できます)
- PlaceholderAPI 2.10.5

## インストール

1. [Release](https://github.com/book000/PlaceholderActionbar/releases)ページを開いてください。
2. 最新のバージョンをダウンロードしてください。
3. Spigot サーバディレクトリの`plugins`ディレクトリにダウンロードした jar ファイルを配置してください。
4. サーバが既に起動している場合は`/reload`もしくは`/stop`を実行してサーバを再起動してください。

## コマンド

### /placeholderactionbar

**パーミッションノード**: `placeholderactionbar.placeholderactionbar`

現在のオン・オフ設定を表示します。

### /placeholderactionbar on

**パーミッションノード**: `placeholderactionbar.on`

機能をオンにします。設定はプレイヤー毎に保持されます。

### /placeholderactionbar off

**パーミッションノード**: `placeholderactionbar.off`

機能をオフにします。設定はプレイヤー毎に保持されます。

### /placeholderactionbar reload

**パーミッションノード**: `placeholderactionbar.reload`

コンフィグを再読み込みします。

## 設定

`plugins/PlaceholderActionbar/config.yml`ファイルで設定します。

### ActionbarText

アクションバーに表示するテキストを指定します。必須です。  
カラーコードを使用する場合、`'`で囲んでください。

デフォルト値: `You are in §b%worldguard_region_owner%§r's §d%worldguard_region_name_capitalized%§r`

### RefreshTick

アクションバーにテキストが定期表示される間隔を指定します。必須です。  
時間は Tick で指定してください。1 秒は 20Tick です。

デフォルト値: `20` (1 秒毎)

## ライセンス

このプロジェクトのライセンスは MIT ライセンスです。
[LICENSE](https://github.com/book000/PlaceholderActionbar/blob/master/LICENSE)
