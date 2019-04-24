//
//  TestButton.h
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import <Cocoa/Cocoa.h>

NS_ASSUME_NONNULL_BEGIN

@interface TestButton : NSButton {
    NSTrackingArea* trackingArea;
    NSRect box;
    NSColor* _color;
}

@property (nonatomic, retain) NSColor* color;

@end

NS_ASSUME_NONNULL_END
