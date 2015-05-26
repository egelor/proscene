/*********************************************************************************
 * bias_tree
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 *********************************************************************************/

package remixlab.bias.event;

import remixlab.bias.core.BogusEvent;
import remixlab.bias.event.shortcut.KeyboardShortcut;

/**
 * A keyboard event is a {@link remixlab.bias.core.BogusEvent} specialization that encapsulates a
 * {@link remixlab.bias.event.shortcut.KeyboardShortcut}. Keyboard shortcuts may be of one form out of two: 1. A single
 * Character; or, 2. A modifier mask (such as: (B_ALT | B_SHIFT)) plus a virtual.
 * <p>
 * <b>Note</b> that virtual key codes are used to report which keyboard key has been pressed, rather than a character
 * generated by the combination of one or more keystrokes (such as "A", which comes from shift and "a"). Their values
 * depend on the platform your running your code. In Java, for instance, have a look at <a
 * href="http://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html">KeyEvent</a> to get some VK_* values.
 * You may use these values to freely choose them as a convention in your code. Have a look at the ProScene's
 * CameraCustomization example.
 */
public class KeyboardEvent extends BogusEvent {
	protected final char key;
	
	public KeyboardEvent(char _key, int modifiers, int vk) {
		super(modifiers, vk);
		key = _key;
	}
	
	/**
	 * Constructs a keyboard event with the <b>modifiers</b> and <b>vk</b> defining its
	 * {@link remixlab.bias.event.shortcut.KeyboardShortcut}.
	 */
	public KeyboardEvent(int modifiers, int vk) {
		super(modifiers, vk);
		key = '\uFFFF';
	}
	
	public KeyboardEvent(char _key, int vk) {
		super(NO_MODIFIER_MASK, vk);
		key = _key;
	}

	/**
	 * Constructs a keyboard event with <b>c</b> defining its {@link remixlab.bias.event.shortcut.KeyboardShortcut}.
	 */
	public KeyboardEvent(int vk) {
		super(NO_MODIFIER_MASK, vk);
		key = '\uFFFF';
	}

	/**
	 * @param other
	 */
	protected KeyboardEvent(KeyboardEvent other) {
		super(other);
		this.key = other.key;
	}

	@Override
	public KeyboardEvent get() {
		return new KeyboardEvent(this);
	}

	@Override
	public KeyboardShortcut shortcut() {
		return new KeyboardShortcut(modifiers(), id());
	}
	
	// not really in used
	public char key() {
		return key;
	}
}