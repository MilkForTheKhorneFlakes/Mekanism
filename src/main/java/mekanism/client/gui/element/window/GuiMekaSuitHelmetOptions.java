package mekanism.client.gui.element.window;

import mekanism.client.gui.IGuiWrapper;
import mekanism.client.gui.element.GuiColorPickerSlot;
import mekanism.client.gui.element.GuiScreenSwitch;
import mekanism.client.gui.element.GuiSlider;
import mekanism.common.MekanismLang;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.gear.HUDElement.HUDColor;
import mekanism.common.inventory.container.SelectedWindowData.WindowType;
import net.minecraft.client.gui.GuiGraphics;

public class GuiMekaSuitHelmetOptions extends GuiWindow {

    public GuiMekaSuitHelmetOptions(IGuiWrapper gui, int x, int y) {
        super(gui, x, y, 140, 115, WindowType.MEKA_SUIT_HELMET);
        interactionStrategy = InteractionStrategy.NONE;
        addChild(new GuiColorPickerSlot(gui, relativeX + 12, relativeY + 32, false, HUDColor.REGULAR::getColor, color -> {
            MekanismConfig.client.hudColor.set(color.rgb());
            // save the updated config info
            MekanismConfig.client.save();
        }));
        addChild(new GuiColorPickerSlot(gui, relativeX + 61, relativeY + 32, false, HUDColor.WARNING::getColor, color -> {
            MekanismConfig.client.hudWarningColor.set(color.rgb());
            // save the updated config info
            MekanismConfig.client.save();
        }));
        addChild(new GuiColorPickerSlot(gui, relativeX + 110, relativeY + 32, false, HUDColor.DANGER::getColor, color -> {
            MekanismConfig.client.hudDangerColor.set(color.rgb());
            // save the updated config info
            MekanismConfig.client.save();
        }));

        GuiSlider slider = addChild(new GuiSlider(gui, relativeX + 10, relativeY + 62, 120, value -> MekanismConfig.client.hudOpacity.set((float) value)));
        slider.setValue(MekanismConfig.client.hudOpacity.get());

        addChild(new GuiScreenSwitch(gui, relativeX + 7, relativeY + 87, 126, MekanismLang.COMPASS.translate(), MekanismConfig.client.hudCompassEnabled, () -> {
            MekanismConfig.client.hudCompassEnabled.set(!MekanismConfig.client.hudCompassEnabled.get());
            // save the updated config info
            MekanismConfig.client.save();
        }));
    }

    @Override
    public void renderForeground(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderForeground(guiGraphics, mouseX, mouseY);

        drawTitleText(guiGraphics, MekanismLang.HELMET_OPTIONS.translate(), 6);
        drawTextExact(guiGraphics, MekanismLang.HUD_OVERLAY.translate(), relativeX + 7, relativeY + 20, headingTextColor());

        drawScaledCenteredText(guiGraphics, MekanismLang.DEFAULT.translate(), relativeX + 21, relativeY + 52, subheadingTextColor(), 0.8F);
        drawScaledCenteredText(guiGraphics, MekanismLang.WARNING.translate(), relativeX + 70, relativeY + 52, subheadingTextColor(), 0.8F);
        drawScaledCenteredText(guiGraphics, MekanismLang.DANGER.translate(), relativeX + 119, relativeY + 52, subheadingTextColor(), 0.8F);

        drawScaledCenteredText(guiGraphics, MekanismLang.OPACITY.translate(), relativeX + 70, relativeY + 75, subheadingTextColor(), 0.8F);
    }
}
