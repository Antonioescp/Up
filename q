[1mdiff --git a/.idea/vcs.xml b/.idea/vcs.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..94a25f7[m
[1m--- /dev/null[m
[1m+++ b/.idea/vcs.xml[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="VcsDirectoryMappings">[m
[32m+[m[32m    <mapping directory="$PROJECT_DIR$" vcs="Git" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/Actor.kt b/app/src/main/java/com/pglabs/canvastest/model/Actor.kt[m
[1mindex e6849df..e785097 100644[m
[1m--- a/app/src/main/java/com/pglabs/canvastest/model/Actor.kt[m
[1m+++ b/app/src/main/java/com/pglabs/canvastest/model/Actor.kt[m
[36m@@ -1,12 +1,23 @@[m
 package com.pglabs.canvastest.model[m
 [m
[31m-import android.graphics.Canvas[m
[31m-[m
 open class Actor(val game: Game) {[m
     var position = Vector2()[m
     var scale = Vector2()[m
     var rotation = Vector2()[m
 [m
[32m+[m[32m    private var drawable = Sprite(game.context)[m
[32m+[m
[32m+[m[32m    var sprite: Int = 0[m
[32m+[m[32m        get() {[m
[32m+[m[32m            return field[m
[32m+[m[32m        }[m
[32m+[m[32m        set(value) {[m
[32m+[m[32m            drawable.set(value)[m
[32m+[m[32m            field = value[m
[32m+[m[32m        }[m
[32m+[m
     open fun update() {}[m
[31m-    open fun draw() {}[m
[32m+[m[32m    open fun draw() {[m
[32m+[m[32m        drawable.draw(position, game.canvas)[m
[32m+[m[32m    }[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/Game.kt b/app/src/main/java/com/pglabs/canvastest/model/Game.kt[m
[1mindex cdaa7cc..b4b7924 100644[m
[1m--- a/app/src/main/java/com/pglabs/canvastest/model/Game.kt[m
[1m+++ b/app/src/main/java/com/pglabs/canvastest/model/Game.kt[m
[36m@@ -4,6 +4,7 @@[m [mimport android.content.Context[m
 import android.graphics.Canvas[m
 import android.graphics.Paint[m
 import android.view.View[m
[32m+[m[32mimport com.pglabs.canvastest.R[m
 [m
 class Game(context: Context): View(context) {[m
 [m
[36m@@ -20,7 +21,11 @@[m [mclass Game(context: Context): View(context) {[m
 [m
     fun initialize() {[m
         paint = Paint()[m
[31m-        gameActors.add(Kirby(this))[m
[32m+[m
[32m+[m[32m        var movingRing = MovingSpriteActorExample(this)[m
[32m+[m[32m        movingRing.sprite = R.drawable.anillitos[m
[32m+[m
[32m+[m[32m        gameActors.add(movingRing)[m
     }[m
 [m
     override fun onDraw(canvas: Canvas) {[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/Kirby.kt b/app/src/main/java/com/pglabs/canvastest/model/Kirby.kt[m
[1mdeleted file mode 100644[m
[1mindex 5454d7d..0000000[m
[1m--- a/app/src/main/java/com/pglabs/canvastest/model/Kirby.kt[m
[1m+++ /dev/null[m
[36m@@ -1,19 +0,0 @@[m
[31m-package com.pglabs.canvastest.model[m
[31m-[m
[31m-import android.graphics.Canvas[m
[31m-import android.graphics.Color[m
[31m-[m
[31m-class Kirby(ownerGame: Game) : Actor(ownerGame) {[m
[31m-[m
[31m-    var move = 1.0f[m
[31m-[m
[31m-    override fun update() {[m
[31m-[m
[31m-    }[m
[31m-[m
[31m-    override fun draw() {[m
[31m-        game.paint.color = Color.BLUE[m
[31m-        game.canvas?.drawLine(0.0f, 0.0f, 100.0f, 100.0f + move, game.paint)[m
[31m-        move += 100.0f * game.deltaTime[m
[31m-    }[m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/MovingSpriteActorExample.kt b/app/src/main/java/com/pglabs/canvastest/model/MovingSpriteActorExample.kt[m
[1mnew file mode 100644[m
[1mindex 0000000..1d0cacd[m
[1m--- /dev/null[m
[1m+++ b/app/src/main/java/com/pglabs/canvastest/model/MovingSpriteActorExample.kt[m
[36m@@ -0,0 +1,14 @@[m
[32m+[m[32mpackage com.pglabs.canvastest.model[m
[32m+[m
[32m+[m[32mimport android.content.Context[m
[32m+[m
[32m+[m[32mclass MovingSpriteActorExample(ownerGame: Game) : Actor(ownerGame) {[m
[32m+[m[32m    var movementSpeed = 100.0f[m
[32m+[m
[32m+[m[32m    override fun update() {[m
[32m+[m[32m        super.update()[m
[32m+[m
[32m+[m[32m        var direction = Vector2(game.width.toFloat(), game.height.toFloat())[m
[32m+[m[32m        position = position + direction.normalized() * movementSpeed * game.deltaTime[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/Sprite.kt b/app/src/main/java/com/pglabs/canvastest/model/Sprite.kt[m
[1mnew file mode 100644[m
[1mindex 0000000..03eac8b[m
[1m--- /dev/null[m
[1m+++ b/app/src/main/java/com/pglabs/canvastest/model/Sprite.kt[m
[36m@@ -0,0 +1,30 @@[m
[32m+[m[32mpackage com.pglabs.canvastest.model[m
[32m+[m
[32m+[m[32mimport android.content.Context[m
[32m+[m[32mimport android.graphics.Canvas[m
[32m+[m[32mimport android.graphics.drawable.Drawable[m
[32m+[m[32mimport androidx.core.content.ContextCompat[m
[32m+[m
[32m+[m[32mclass Sprite(private var ctx: Context) {[m
[32m+[m[32m    private var image: Drawable? = null[m
[32m+[m
[32m+[m[32m    val height[m
[32m+[m[32m    get() = image?.intrinsicHeight[m
[32m+[m
[32m+[m[32m    val width[m
[32m+[m[32m    get() = image?.intrinsicWidth[m
[32m+[m
[32m+[m[32m    fun set(id: Int) {[m
[32m+[m[32m        image = ContextCompat.getDrawable(ctx, id)[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    fun draw(position: Vector2, canvas: Canvas?) {[m
[32m+[m[32m        image?.setBounds([m
[32m+[m[32m            position.x.toInt() - width!!.toInt(),[m
[32m+[m[32m            position.y.toInt() - height!!.toInt(),[m
[32m+[m[32m            position.x.toInt() + width!!.toInt(),[m
[32m+[m[32m            position.y.toInt() + height!!.toInt(),[m
[32m+[m[32m        )[m
[32m+[m[32m        image?.draw(canvas!!)[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/pglabs/canvastest/model/Vector2.kt b/app/src/main/java/com/pglabs/canvastest/model/Vector2.kt[m
[1mindex 891affd..32b456f 100644[m
[1m--- a/app/src/main/java/com/pglabs/canvastest/model/Vector2.kt[m
[1m+++ b/app/src/main/java/com/pglabs/canvastest/model/Vector2.kt[m
[36m@@ -18,6 +18,7 @@[m [mclass Vector2 {[m
     }[m
 [m
     fun magnitude() = sqrt(x * x + y * y)[m
[32m+[m[32m    fun normalized() = Vector2(x, y) / magnitude()[m
 [m
     operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)[m
     operator fun unaryMinus() = Vector2(-x, -y)[m
[1mdiff --git a/app/src/main/res/drawable/anillitos.png b/app/src/main/res/drawable/anillitos.png[m
[1mnew file mode 100644[m
[1mindex 0000000..caf2826[m
Binary files /dev/null and b/app/src/main/res/drawable/anillitos.png differ
