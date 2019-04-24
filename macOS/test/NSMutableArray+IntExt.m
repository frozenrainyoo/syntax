//
//  NSMutableArray+IntExt.m
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NSMutableArray+IntExt.h"

@implementation NSMutableArray (IntExt)

-(void)addInt:(int)value {
    [self addObject:@(value)];
}

-(int)intAtIndex:(NSUInteger)index {
    NSNumber* num = self[index];
    return [num intValue];
}

@end
