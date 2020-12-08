/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2020 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.bossbar;

import java.util.Set;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.util.Index;
import net.kyori.examination.Examinable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * A bossbar.
 *
 * @since 4.0.0
 */
public interface BossBar extends Examinable {
  /**
   * The minimum value the progress can be.
   *
   * @since 4.2.0
   */
  float MIN_PROGRESS = 0f;
  /**
   * The maximum value the progress can be.
   *
   * @since 4.2.0
   */
  float MAX_PROGRESS = 1f;
  /**
   * The minimum value the progress can be.
   *
   * @deprecated for removal since 4.2.0, use {@link #MIN_PROGRESS}
   * @since 4.0.0
   */
  @Deprecated
  float MIN_PERCENT = MIN_PROGRESS;
  /**
   * The maximum value the progress can be.
   *
   * @deprecated for removal since 4.2.0, use {@link #MAX_PROGRESS}
   * @since 4.0.0
   */
  @Deprecated
  float MAX_PERCENT = MAX_PROGRESS;

  /**
   * Creates a new bossbar.
   *
   * @param name the name
   * @param progress the progress, between 0 and 1
   * @param color the color
   * @param overlay the overlay
   * @return a bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @since 4.3.0
   */
  static @NonNull BossBar bossBar(final @NonNull ComponentLike name, final float progress, final @NonNull Color color, final @NonNull Overlay overlay) {
    BossBarImpl.checkProgress(progress);
    return bossBar(name.asComponent(), progress, color, overlay);
  }

  /**
   * Creates a new bossbar.
   *
   * @param name the name
   * @param progress the progress, between 0 and 1
   * @param color the color
   * @param overlay the overlay
   * @return a bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @since 4.0.0
   */
  static @NonNull BossBar bossBar(final @NonNull Component name, final float progress, final @NonNull Color color, final @NonNull Overlay overlay) {
    BossBarImpl.checkProgress(progress);
    return new BossBarImpl(name, progress, color, overlay);
  }

  /**
   * Creates a new bossbar.
   *
   * @param name the name
   * @param progress the progress, between 0 and 1
   * @param color the color
   * @param overlay the overlay
   * @param flags the flags
   * @return a bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @since 4.3.0
   */
  static @NonNull BossBar bossBar(final @NonNull ComponentLike name, final float progress, final @NonNull Color color, final @NonNull Overlay overlay, final @NonNull Set<Flag> flags) {
    BossBarImpl.checkProgress(progress);
    return bossBar(name.asComponent(), progress, color, overlay, flags);
  }

  /**
   * Creates a new bossbar.
   *
   * @param name the name
   * @param progress the progress, between 0 and 1
   * @param color the color
   * @param overlay the overlay
   * @param flags the flags
   * @return a bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @since 4.0.0
   */
  static @NonNull BossBar bossBar(final @NonNull Component name, final float progress, final @NonNull Color color, final @NonNull Overlay overlay, final @NonNull Set<Flag> flags) {
    BossBarImpl.checkProgress(progress);
    return new BossBarImpl(name, progress, color, overlay, flags);
  }

  /**
   * Gets the name.
   *
   * @return the name
   * @since 4.0.0
   */
  @NonNull Component name();

  /**
   * Sets the name.
   *
   * @param name the name
   * @return the bossbar
   * @since 4.3.0
   */
  @Contract("_ -> this")
  default @NonNull BossBar name(final @NonNull ComponentLike name) {
    return this.name(name.asComponent());
  }

  /**
   * Sets the name.
   *
   * @param name the name
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar name(final @NonNull Component name);

  /**
   * Gets the progress.
   *
   * <p>The progress is a value between 0 and 1.</p>
   *
   * @return the progress
   * @since 4.0.0
   */
  float progress();

  /**
   * Sets the progress.
   *
   * <p>The progress is a value between 0 and 1.</p>
   *
   * @param progress the progress
   * @return the bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar progress(final float progress);

  /**
   * Gets the progress.
   *
   * <p>The progress is a value between 0 and 1.</p>
   *
   * @return the progress
   * @deprecated for removal since 4.2.0, use {@link #progress()}
   * @since 4.0.0
   */
  @Deprecated
  default float percent() {
    return this.progress();
  }

  /**
   * Sets the progress.
   *
   * <p>The progress is a value between 0 and 1.</p>
   *
   * @param progress the progress
   * @return the bossbar
   * @throws IllegalArgumentException if progress is less than 0 or greater than 1
   * @deprecated for removal since 4.2.0, use {@link #progress(float)}
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @Deprecated
  default @NonNull BossBar percent(final float progress) {
    return this.progress(progress);
  }

  /**
   * Gets the color.
   *
   * @return the color
   * @since 4.0.0
   */
  @NonNull Color color();

  /**
   * Sets the color.
   *
   * @param color the color
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar color(final @NonNull Color color);

  /**
   * Gets the overlay.
   *
   * @return the overlay
   * @since 4.0.0
   */
  @NonNull Overlay overlay();

  /**
   * Sets the overlay.
   *
   * @param overlay the overlay
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar overlay(final @NonNull Overlay overlay);

  /**
   * Gets the flags.
   *
   * @return the flags
   * @since 4.0.0
   */
  @NonNull Set<Flag> flags();

  /**
   * Sets the flags.
   *
   * @param flags the flags
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar flags(final @NonNull Set<Flag> flags);

  /**
   * Checks if this bossbar has a flag.
   *
   * @param flag the flag
   * @return {@code true} if this bossbar has the flag, {@code false} otherwise
   * @since 4.0.0
   */
  boolean hasFlag(final @NonNull Flag flag);

  /**
   * Adds a flag to this bossbar.
   *
   * @param flag the flag
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar addFlag(final @NonNull Flag flag);

  /**
   * Removes a flag from this bossbar.
   *
   * @param flag the flag
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar removeFlag(final @NonNull Flag flag);

  /**
   * Adds flags to this bossbar.
   *
   * @param flags the flags
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar addFlags(final @NonNull Flag@NonNull... flags);

  /**
   * Removes flags from this bossbar.
   *
   * @param flags the flags
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar removeFlags(final @NonNull Flag@NonNull... flags);

  /**
   * Adds flags to this bossbar.
   *
   * @param flags the flags
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar addFlags(final @NonNull Iterable<Flag> flags);

  /**
   * Removes flags from this bossbar.
   *
   * @param flags the flags
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar removeFlags(final @NonNull Iterable<Flag> flags);

  /**
   * Adds a listener.
   *
   * @param listener a listener
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract(value = "_ -> this")
  @NonNull BossBar addListener(final @NonNull Listener listener);

  /**
   * Removes a listener.
   *
   * @param listener a listener
   * @return the bossbar
   * @since 4.0.0
   */
  @Contract("_ -> this")
  @NonNull BossBar removeListener(final @NonNull Listener listener);

  /**
   * A listener for changes that happen on a {@link BossBar}.
   *
   * @since 4.0.0
   */
  interface Listener {
    /**
     * Bossbar name changed.
     *
     * @param bar the bossbar
     * @param oldName the old name
     * @param newName the new name
     * @since 4.0.0
     */
    default void bossBarNameChanged(final @NonNull BossBar bar, final @NonNull Component oldName, final @NonNull Component newName) {
    }

    /**
     * Bossbar progress changed.
     *
     * @param bar the bossbar
     * @param oldProgress the old progress
     * @param newProgress the new progress
     * @since 4.0.0
     */
    default void bossBarProgressChanged(final @NonNull BossBar bar, final float oldProgress, final float newProgress) {
      this.bossBarPercentChanged(bar, oldProgress, newProgress);
    }

    /**
     * Bossbar progress changed.
     *
     * @param bar the bossbar
     * @param oldProgress the old progress
     * @param newProgress the new progress
     * @deprecated for removal since 4.2.0, use {@link #bossBarProgressChanged(BossBar, float, float)}
     * @since 4.0.0
     */
    @Deprecated
    default void bossBarPercentChanged(final @NonNull BossBar bar, final float oldProgress, final float newProgress) {
    }

    /**
     * Bossbar color changed.
     *
     * @param bar the bossbar
     * @param oldColor the old color
     * @param newColor the new color
     * @since 4.0.0
     */
    default void bossBarColorChanged(final @NonNull BossBar bar, final @NonNull Color oldColor, final @NonNull Color newColor) {
    }

    /**
     * Bossbar overlay changed.
     *
     * @param bar the bossbar
     * @param oldOverlay the old overlay
     * @param newOverlay the new overlay
     * @since 4.0.0
     */
    default void bossBarOverlayChanged(final @NonNull BossBar bar, final @NonNull Overlay oldOverlay, final @NonNull Overlay newOverlay) {
    }

    /**
     * Bossbar flags changed.
     *
     * @param bar the bossbar
     * @param flagsAdded the flags added to the bossbar
     * @param flagsRemoved the flags removed from the bossbar
     * @since 4.0.0
     */
    default void bossBarFlagsChanged(final @NonNull BossBar bar, final @NonNull Set<Flag> flagsAdded, final @NonNull Set<Flag> flagsRemoved) {
    }
  }

  /**
   * One of the colors the bar component of a {@link BossBar}.
   *
   * <p>This color does <em>not</em> affect the color of the bar's name text.</p>
   *
   * <p>The exact color for each named value may vary slightly based on game version.</p>
   *
   * @since 4.0.0
   */
  enum Color {
    /**
     * Pink.
     *
     * @since 4.0.0
     */
    PINK("pink"),
    /**
     * Blue.
     *
     * @since 4.0.0
     */
    BLUE("blue"),
    /**
     * Red.
     *
     * @since 4.0.0
     */
    RED("red"),
    /**
     * Green.
     *
     * @since 4.0.0
     */
    GREEN("green"),
    /**
     * Yellow.
     *
     * @since 4.0.0
     */
    YELLOW("yellow"),
    /**
     * Purple.
     *
     * @since 4.0.0
     */
    PURPLE("purple"),
    /**
     * White.
     *
     * @since 4.0.0
     */
    WHITE("white");

    /**
     * The name map.
     *
     * @since 4.0.0
     */
    public static final Index<String, Color> NAMES = Index.create(Color.class, color -> color.name);
    private final String name;

    Color(final String name) {
      this.name = name;
    }
  }

  /**
   * Flags to control toggleable effects of a boss bar.
   *
   * @since 4.0.0
   */
  enum Flag {
    /**
     * If the screen should be darkened.
     *
     * @since 4.0.0
     */
    DARKEN_SCREEN("darken_screen"),
    /**
     * If boss music should be played.
     *
     * @since 4.0.0
     */
    PLAY_BOSS_MUSIC("play_boss_music"),
    /**
     * If world fog should be created.
     *
     * @since 4.0.0
     */
    CREATE_WORLD_FOG("create_world_fog");

    /**
     * The name map.
     *
     * <p>These names are not "official", but we want to provide them to allow serializers to be consistent.</p>
     *
     * @since 4.0.0
     */
    public static final Index<String, Flag> NAMES = Index.create(Flag.class, flag -> flag.name);
    private final String name;

    Flag(final String name) {
      this.name = name;
    }
  }

  /**
   * An overlay on the bar component of a boss bar.
   *
   * @since 4.0.0
   */
  enum Overlay {
    /**
     * A progress bar.
     *
     * @since 4.0.0
     */
    PROGRESS("progress"),
    /**
     * A bar with {@code 6} notches.
     *
     * @since 4.0.0
     */
    NOTCHED_6("notched_6"),
    /**
     * A bar with {@code 10} notches.
     *
     * @since 4.0.0
     */
    NOTCHED_10("notched_10"),
    /**
     * A bar with {@code 12} notches.
     *
     * @since 4.0.0
     */
    NOTCHED_12("notched_12"),
    /**
     * A bar with {@code 20} notches.
     *
     * @since 4.0.0
     */
    NOTCHED_20("notched_20");

    /**
     * The name map.
     *
     * @since 4.0.0
     */
    public static final Index<String, Overlay> NAMES = Index.create(Overlay.class, overlay -> overlay.name);
    private final String name;

    Overlay(final String name) {
      this.name = name;
    }
  }
}
