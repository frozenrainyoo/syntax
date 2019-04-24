//
//  TestButton.m
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import "TestButton.h"

@implementation TestButton

// Xcode 4.4 이후로 @synthesize를 직접 작성하지 않아도 컴파일러가 알아서 @synthesize를 추가해준다.
// @synthesize color = _color;

- (void)drawRect:(NSRect)dirtyRect {
    [_color set];
    NSRectFill(dirtyRect);
    [[self title] drawInRect:dirtyRect withAttributes:nil];
}

- (instancetype)initWithFrame:(NSRect)frameRect {
    self = [super initWithFrame:frameRect];

    if (self) {
        [self setColor:[NSColor whiteColor]];
    }

    return self;
}

- (void)updateTrackingAreas
{
    [self removeTrackingArea:trackingArea];

    NSRect rect = [self frame];
    rect.origin.x -= rect.origin.x;
    rect.origin.y -= rect.origin.y;

    NSTrackingAreaOptions options = NSTrackingMouseEnteredAndExited |
                                    NSTrackingMouseMoved |
                                    NSTrackingActiveAlways |
                                    NSTrackingEnabledDuringMouseDrag;

    trackingArea = [[NSTrackingArea alloc] initWithRect:rect
                                           options: options
                                           owner:self
                                           userInfo:nil];

    [self addTrackingArea:trackingArea];
}

- (void)mouseEntered:(NSEvent *)event {
    NSLog(@"%s", __func__);

    [self setColor:[NSColor greenColor]];
    [self setNeedsDisplay:YES];
    [self displayIfNeeded];

}

- (void)mouseMoved:(NSEvent *)event {
    NSPoint point = [self convertPoint:[event locationInWindow] fromView:nil];
    NSLog(@"%s point(%f, %f)", __func__, point.x, point.y);

    [self setColor:[NSColor greenColor]];
    [self setNeedsDisplay:YES];
    [self displayIfNeeded];
}

- (void)mouseExited:(NSEvent *)event {
    NSLog(@"%s", __func__);

    [self setColor:[NSColor whiteColor]];
    [self setNeedsDisplay:YES];
    [self displayIfNeeded];
}

@end
